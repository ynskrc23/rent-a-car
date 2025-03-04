# Rent-A-Car API

**Rent-A-Car API** projesi, araç kiralama hizmeti sunan bir platformun backend kısmını oluşturmak için geliştirilmiştir. API, araç kiralama işlemlerini yönetmek, ödeme işlemleri yapmak, bakım ve model gibi verileri yönetmek için kullanılır. **Spring Boot** kullanılarak geliştirilmiştir ve **PostgreSQL** veritabanını kullanmaktadır.

---

## Proje Yapısı

Bu proje, aşağıdaki temel özellikleri sağlar:

### 1. **API Endpoints**
API, araç kiralama işlemleriyle ilgili tüm veri yönetimini sağlamak için çeşitli uç noktalar sunar. Bu uç noktalar şunlardır:
- **Brand API**: Araç markalarını yönetir.
- **Car API**: Araçların kaydını ve durumunu yönetir.
- **Invoice API**: Kiralama faturalarını oluşturur ve yönetir.
- **Maintenance API**: Araç bakımlarını yönetir.
- **Model API**: Araç modellerini yönetir.
- **Payment API**: Ödeme işlemleri gerçekleştirir.
- **Rental API**: Araç kiralama işlemlerini yönetir.

### 2. **JWT Authentication** (Kimlik Doğrulama)
Proje, güvenlik için **JWT (JSON Web Token)** kullanmaktadır. API'ye yapılan her istekte, JWT token ile kimlik doğrulaması yapılır. Geçerli bir token olmadan API'ye erişim sağlanamaz.

### 3. **Swagger UI**
API'nin tüm uç noktaları ve kullanımı **Swagger UI** ile dökümante edilmiştir. Swagger UI üzerinden API'lerinizi görsel olarak test edebilir ve dokümantasyona göz atabilirsiniz.

### 4. **Veri Erişimi ve İş Mantığı**
Veri erişimi için **Spring Data JPA** kullanılırken, iş mantığı katmanı **Service** sınıflarında yer almaktadır. Bu katmanlar, uygulamanın sürdürülebilirliğini ve esnekliğini artırır.

---

## Kullanılan Teknolojiler

- **Java 17+**: Projenin geliştirilmesi için Java 17 veya daha yeni bir sürüm kullanılmıştır.
- **Spring Boot**: Mikroservis mimarisi için Spring Boot kullanılmıştır.
- **Spring Data JPA**: Veritabanı işlemleri için Spring Data JPA kullanılmıştır.
- **Hibernate**: Veritabanı ile iletişimde **Hibernate ORM** kullanılmaktadır.
- **PostgreSQL**: Veritabanı olarak PostgreSQL kullanılmıştır.
- **Lombok**: Kod tekrarı azaltmak ve daha temiz bir kod yazmak için **Lombok** kütüphanesi kullanılmıştır.
- **Maven**: Proje bağımlılık yönetimi için **Maven** kullanılmıştır.
- **Swagger**: API dokümantasyonu ve test araçları için **Swagger** entegrasyonu sağlanmıştır.

---

## Proje Yapılandırması

### **`application.properties`**
API'yi çalıştırmak için gerekli olan yapılandırma ayarlarını `application.properties` dosyasına ekleyebilirsiniz. Özellikle veritabanı ve JWT ayarlarını burada yapılandırmanız gerekmektedir.

Örnek yapılandırma:

```properties
# PostgreSQL Bağlantı Ayarları
spring.datasource.url=jdbc:postgresql://localhost:5432/rentacar
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate Ayarları
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# JWT Ayarları
jwt.secret-key=your-secret-key
jwt.issuer=rent-a-car-issuer
jwt.audience=rent-a-car-audience
jwt.expiration-time=3600
