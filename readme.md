# Autologin for 1.7.10

# How it works
It listens for a message containing "/login",\ then reads the config for the password and sends command "/login PASSWORD" and sets a flag to not send the password again

# Config
/config/sascha-autologin.cfg

```
general {
  S:password=PASSWORD
}
```
