# Code Review Example: CalculadoraMala.java

## 🚨 CODE REJECTED - Banking Standards Violation

This code submission has been **REJECTED** by our banking institution due to **CRITICAL VIOLATIONS** of established coding standards. This code cannot proceed to production under any circumstances.

---

## ⚠️ **BANKING COMPLIANCE VIOLATIONS**

### 🚨 **CRITICAL SECURITY RISKS**

- **File I/O without validation**: Lines 51-53 create files without security checks
- **Resource leaks**: Scanner and FileWriter not properly closed in try-with-resources
- **Input validation missing**: No validation for division by zero (line 89)
- **Exception swallowing**: Catch blocks hide critical errors (lines 163-165)

### 🚨 **NAMING CONVENTION VIOLATIONS**

**UNACCEPTABLE**: Extensive use of `snake_case` throughout the codebase:

- Line 9: `operacion_actual` → must be `operacionActual`
- Line 10: `is_debug_mode` → must be `isDebugMode`
- Line 11: `historial_operaciones` → must be `historialOperaciones`
- Line 12: `input_scanner` → must be `inputScanner`
- Line 13: `archivo_log` → must be `archivoLog`
- Line 32: `ejecutar_calculadora()` → must be `ejecutarCalculadora()`
- Lines 42-150: Multiple variable names violating camelCase standard

### 🚨 **INDENTATION VIOLATIONS**

**INCONSISTENT**: Mixed indentation patterns detected:

- Lines 25-180: Using 4 spaces instead of required 2 spaces
- Some sections appear to use tabs mixed with spaces
- **Required**: All code must use exactly 2 spaces for indentation

---

## 🚨 **CRITICAL ISSUES** (Must Fix Before Resubmission)

### Architecture Violations

1. **MASSIVE SRP Violation**:
   - `CalculadoraMala` class handles UI, calculations, file I/O, logging, and business logic
   - Single method `ejecutar_calculadora()` is 150+ lines (exceeds 20-line banking limit)
2. **God Class Anti-pattern**:

   - One class doing everything violates single responsibility principle
   - Impossible to unit test individual components

3. **Open/Closed Principle Violation**:
   - Giant switch statement (lines 42-150) requires modification for every new operation
   - No abstraction layer for mathematical operations

### Security & Performance Issues

4. **Resource Management**:
   - FileWriter not closed properly in constructor
   - Scanner resource leak potential
5. **Input Validation Missing**:

   ```java
   // DANGEROUS - No division by zero check
   resultado = num1_div / num2_div;  // Line 89
   ```

6. **Exception Handling**:
   ```java
   // POOR - Hiding exceptions
   catch (IOException e) {
       System.out.println("Error al guardar archivo: " + e.getMessage());
   }
   ```

---

## ⚡ **HIGH PRIORITY** (Architecture Refactoring Required)

### Code Duplication

- Mathematical operation pattern repeated 7 times (lines 42-120)
- Debug logging duplicated in every operation
- File writing logic repeated multiple times

### Suggested Refactoring Structure:

```java
// ✅ CORRECT Banking Standard Architecture
public interface MathOperation {
  BigDecimal calculate(BigDecimal... operands);
}

public class Calculator {
  private final List<MathOperation> operations;
  private final OperationLogger logger;
  private final InputValidator validator;

  // Clean, focused methods with single responsibility
  public BigDecimal performOperation(OperationType type, BigDecimal... operands) {
    validator.validate(operands);
    MathOperation operation = getOperation(type);
    BigDecimal result = operation.calculate(operands);
    logger.logOperation(type, operands, result);
    return result;
  }
}
```

---

## 📋 **MEDIUM PRIORITY** (After Critical Issues Fixed)

### Code Quality Improvements

- Add comprehensive JavaDoc documentation
- Implement proper error messages with error codes
- Add input sanitization for all user inputs
- Implement proper logging framework instead of System.out.println

### Testing Requirements

- Unit tests for each mathematical operation (minimum 80% coverage)
- Integration tests for file operations
- Security tests for input validation

---

## 🏦 **BANKING INSTITUTION FINAL VERDICT**

> **STATUS**: ❌ **COMPLETELY REJECTED**
>
> **SEVERITY**: CRITICAL - Multiple Category A Violations
>
> **ACTION REQUIRED**: Complete architectural redesign and refactoring
>
> **TIMELINE**: This code must be completely rewritten following banking standards before any resubmission consideration.
>
> **NOTE**: Our banking institution does not accept code with these fundamental violations. The naming conventions, indentation standards, and architectural principles are non-negotiable requirements for financial software systems.

---

## 📝 **REFACTORING MANDATE**

Before resubmission, the following is REQUIRED:

1. ✅ Convert ALL variable names to camelCase
2. ✅ Standardize ALL indentation to exactly 2 spaces
3. ✅ Break down into multiple focused classes following SRP
4. ✅ Implement proper interfaces and abstraction layers
5. ✅ Add comprehensive input validation and error handling
6. ✅ Implement try-with-resources for all I/O operations
7. ✅ Add unit tests with minimum 80% coverage
8. ✅ Follow clean code principles (methods < 20 lines)

**Estimated Refactoring Effort**: 3-5 days for complete rewrite

**Next Review**: Schedule only after ALL violations are addressed

---

_This review conducted under Banking Code Quality Standards v2.1_
_Reviewer: Senior Banking Software Architect_
_Date: November 12, 2025_
