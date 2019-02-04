INSERT INTO tabela_usuario_1 (vcnome, vccidade, vcuf, vcbairro, vcendereco, vcnumerocasa, vcsiape, vcdatanascimento, vccelular, vctelefone, vccpf, vcrg, vcsituacao, vcemail,
vcinformacoesadicionais, vcsexo, vcnucleo, busuarioativo)
SELECT 
vcnome, vccidade, vcuf, vcbairro, vcendereco, vcnumerocasa, vcsiape, vcdatanascimento, vccelular, vctelefone, vccpf, vcrg, vcsituacao, vcemail,
vcinformacoesadicionais, vcsexo, vcnucleo, busuarioativo
FROM tabela_usuario