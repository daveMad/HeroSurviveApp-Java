# Hero Survive App

## Nasıl Çalıştırılır?
- Bu bir konsol uygulamasıdır.Çalıştırmak için ana dizinde yer alan (*Master*), **heroapp.jar** adlı dosyayı kullanabilirsiniz. Dosyayı indirdikten sonra bulunduğu klasörde komut istemini açın ve şu komutu girin : `java -jar heroapp.jar`


## Dizayn
- İlk olarak *Enemy* türlerinin ve *Hero* nun birer karakter oldukları, ortak bir **interface** sahip olduklarını ve uygulamayı bir oyun yapısına benzettim
- Oyunda Bir harita olmalı, kullanıcının verdiği dosyadan ilgili data'yı aldıktan sonra bu haritayı belirtip, burada ilgili nesneleri bulundaklı pozisyonlara koymalıyız. *Enemy* ve *Hero* birbirleriyle karşılaşırsa, küçük bir savaş düzenlenmeli ve sonucuna göre oyunun bitip bitmediğine karar verilmeli
- Bir flag var, oyun bittimi adında. Bitesiye kadar, sürekli kontrol etmeliyiz, *Hero* herhangi bir *Enemy* türünden nesneyle karşılaşıyormu veya *Hero* haritanın sonuna vardımı, ki o da *Resource* adlı nesnenin bulunduğu pozisyonu belirtmektedir, ve sonucuna göre oyun devam etmeli veya sonuçları yazdırıp bitmeli
- Son olarak, ilgili verilerin kullanıcıdan alınması ve oyunda gerçekleşen olayların bir yerde tutulmasıydı. Bunlar için **singleton** tasarıda birer servis yazmak gerekiyordu.
