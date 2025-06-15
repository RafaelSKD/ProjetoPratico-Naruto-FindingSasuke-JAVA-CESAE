package Jogo.InicializarObjetos.Item;

import Itens.AtaqueChakra.AtaqueChakra;
import Itens.Enum.TipoItem;
import Itens.Item;

import java.util.ArrayList;
import java.util.List;

public class InicializarAtaques {
    public static List<AtaqueChakra> inicializarAtaquesChakra() {
        List<AtaqueChakra> ataques = new ArrayList<>();

// Naruto
        ataques.add(new AtaqueChakra("Rasengan", TipoItem.ATAQUEESPECIAL, 100.0, 90.0));
        ataques.add(new AtaqueChakra("Rasen-Shuriken", TipoItem.ATAQUEESPECIAL, 160.0, 150.0));

// Sasuke
        ataques.add(new AtaqueChakra("Chidori", TipoItem.ATAQUEESPECIAL, 110.0, 90.0));
        ataques.add(new AtaqueChakra("Amaterasu", TipoItem.ATAQUEESPECIAL, 150.0, 140.0));

// ░░░ ATAQUES ESPECIAIS DOS PERSONAGENS ░░░
// Gaara
        ataques.add(new AtaqueChakra("Caixão de Areia", TipoItem.ATAQUEESPECIAL, 110.0, 75.0));
        ataques.add(new AtaqueChakra("Areia Imperial: Prisão Funerária", TipoItem.ATAQUEESPECIAL, 170.0, 120.0));

// Ohnoki e Kurotsuchi (Liberação de Poeira)
        ataques.add(new AtaqueChakra("Liberação de Poeira: Desintegração", TipoItem.ATAQUEESPECIAL, 130.0, 95.0));
        ataques.add(new AtaqueChakra("Jutsu Supremo: Estilo de Poeira Atômica", TipoItem.ATAQUEESPECIAL, 180.0, 140.0));

// A (Raikage) e Killer Bee
        ataques.add(new AtaqueChakra("Lariat Relâmpago", TipoItem.ATAQUEESPECIAL, 120.0, 80.0));
        ataques.add(new AtaqueChakra("Manto Relâmpago Supremo", TipoItem.ATAQUEESPECIAL, 180.0, 130.0));

// Zabuza e Haku
        ataques.add(new AtaqueChakra("Névoa Silenciosa", TipoItem.ATAQUEESPECIAL, 110.0, 70.0));
        ataques.add(new AtaqueChakra("Execução Oculta na Névoa", TipoItem.ATAQUEESPECIAL, 160.0, 110.0));

// Pain (Nagato)
        ataques.add(new AtaqueChakra("Shinra Tensei", TipoItem.ATAQUEESPECIAL, 140.0, 100.0));
        ataques.add(new AtaqueChakra("Chibaku Tensei", TipoItem.ATAQUEESPECIAL, 200.0, 150.0));

// ░░░ ATAQUES NORMAIS PARA OS OUTROS ░░░
// Karin Uzumaki
        ataques.add(new AtaqueChakra("Pulso Curativo Uzumaki", TipoItem.ATAQUEESPECIAL, 80.0, 60.0));

// Orochimaru
        ataques.add(new AtaqueChakra("Estilo das Cobras Ocultas", TipoItem.ATAQUEESPECIAL, 100.0, 75.0));

// Kankuro e Sasori
        ataques.add(new AtaqueChakra("Controle de Marionetes Humanas", TipoItem.ATAQUEESPECIAL, 110.0, 80.0));

// Deidara
        ataques.add(new AtaqueChakra("Argila Explosiva: C2", TipoItem.ATAQUEESPECIAL, 115.0, 85.0));

// Kabuto
        ataques.add(new AtaqueChakra("Respiração Venenosa", TipoItem.ATAQUEESPECIAL, 100.0, 70.0));

// Konan
        ataques.add(new AtaqueChakra("Dança de Papel Cortante", TipoItem.ATAQUEESPECIAL, 105.0, 75.0));

// Haku
        ataques.add(new AtaqueChakra("Espelhos de Gelo e Senbons", TipoItem.ATAQUEESPECIAL, 100.0, 80.0));

// Chojuro
        ataques.add(new AtaqueChakra("Estilo Oito Espadas", TipoItem.ATAQUEESPECIAL, 125.0, 90.0));

// Darui
        ataques.add(new AtaqueChakra("Pantera Negra Raiton", TipoItem.ATAQUEESPECIAL, 110.0, 85.0));

        return ataques;
    }
}
