public class Agenda {
    private Contato[] agenda = new Contato[10];

    public void novoContato(String name, String phone, String birthday) {
        for (int i=0; i<agenda.length; i++) {
            if (agenda[i] == null) {
                agenda[i] = new Contato(i, name, phone, birthday);
                atualizarPrevia();
                System.out.println("Cadastro realizado com sucesso!");
                return;
            }
        }
        System.out.println("Agenda sem espaço!");
    }

    public void excluirContato(int id) {
        for (int i=0; i<agenda.length; i++) {
            if (agenda[i] != null) {
                if (agenda[i].id == id) {
                    agenda[i] = null;
                    atualizarPrevia();
                    System.out.println("Cadastro excluído com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Contato não encontrado!");
    }
    public void exibirContato(int id) {
        if (agenda[id] != null) {
            atualizarPrevia();
            System.out.println();
            System.out.println("id: " + agenda[id].getId());
            System.out.println("nome: " + agenda[id].getName());
            System.out.println("telefone: " + agenda[id].getPhone());
            System.out.println("aniversário: " + agenda[id].getBirthday());
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public void editarContato(int id, String name, String phone, String birthday) {
        for (int i=0; i<agenda.length; i++) {
            if (agenda[i] != null) {
                if (agenda[i].id == id) {
                    if (name != null) agenda[i].setName(name);
                    if (phone != null) agenda[i].setPhone(phone);
                    if (birthday != null) agenda[i].setBirthday(birthday);
                    atualizarPrevia();
                    System.out.println("Cadastro editado com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Contato não encontrado!");
    }

    public void atualizarPrevia() {
        System.out.print('[');
        for (int i=0; i<agenda.length; i++) {
            System.out.print(i + " - ");
            if (agenda[i] != null) {
                System.out.print(agenda[i].getName());
            }
            if (i < agenda.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(']');
    }
}
