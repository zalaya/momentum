# Authentication Requirements

## Register

- If the username is null, an exception is thrown.
- If the username is already registered, an exception is thrown.
- If the username contains invalid characters, an exception is thrown.
- If the email is null, an exception is thrown.
- If the email format is invalid, an exception is thrown.
- If the email domain is from a temporary email provider, an exception is thrown.
- If the email is already registered, an exception is thrown.
- If the password is null, an exception is thrown.
- If the password does not meet the security policy, an exception is thrown.
- If the password contains the username or email, an exception is thrown.
- If the parameters are valid, a verification email is sent.
