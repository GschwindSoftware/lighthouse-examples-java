# Beispiel: API-Zugriff auf Financial Lighthouse

Das Beispiel zeigt den Zugriff auf die Financial Lighthouse API mit Java. Im Besonderen wird:

1. Ein Kunde angelegt
2. Ein Finanzplan angelegt
3. Der Status Quo des Kunden im Finanzplan erfasst
  a. Finanzvorgänge
  b. Familienstammbaum
4. Eine Liquiditätsauswertung erzeugt

## Konfiguration

Das Beispiel benötigt einen gültigen Zugang zu Financial Lighthouse und die Zugangsdaten eines API-Client. Um einen API-Client zu erzeugen:

1. Rufen sie das [Administrationsportal](https://www.financial-lighthouse.de/admin) auf.
2. Klicken Sie auf "Entwicklerportal" in der Navigation rechts oben Sollten Sie den Eintrag nicht sehen, weisen Sie sich oder Ihr Administrator Sie einer Gruppe zu, die das Recht "Zugriff auf den Entwicklerbereich." beistzt:
    1. Zugang → Gruppen
    2. Eine neue Gruppe erzeugen oder eine bestehende anklicken
    3. Auf der Detailseite der Gruppe den Tab Berechtigungen wählen
    4. "Zugriff auf den Entwicklerbereich" wählen (`admin:dev`)
3. Erzeugen Sie im Entwicklerportal unter "Clients" einen neuen Client vom Typ "API Zugriff"
4. Notieren Sie sich *ID* und *Secret*
5. Wählen Sie im Tab "Berechtigungen" der Detailsansicht des Clients:
    1. "Vollzugriff auf die Nachfolgeplanung." (`estate`)
    2. "Vollzugriff auf die Finanzplanung." (`financial`)

Passen Sie dann die Einstellungen in `src/main/resources/application.yml` an:

```yaml
config:
  oauth2:
    client:
      # Entspricht einem Client vom Typ "API Zugriff" im Entwicklerportal
      # https://oauth.net/2/grant-types/
      grant-type: client_credentials
      # Die Werte sind der Detailansicht eines Clients im Entwicklerportal zu entnehmen.
      clientId: Ihre Client ID
      clientSecret: Ihr Client Secret
      # Der Client muss diese Scopes unterstützen. Siehe Tab "Berechtigungen" in der
      # Detailansicht eines Clients im Entwicklerportal
      scope: financial estate
      # https://auth.financial-lighthouse.de/.well-known/openid-configuration
      accessTokenUri: https://auth.financial-lighthouse.de/connect/token
```
