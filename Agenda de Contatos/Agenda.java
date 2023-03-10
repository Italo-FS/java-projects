import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> agenda = new ArrayList(10);

    public void novoContato(String name, String phone, String birthday) {
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i) == null) {
                agenda.set(i, new Contato(i, name, phone, birthday));
                atualizarPrevia();
                System.out.println("Cadastro realizado com sucesso!");
                return;
            }
        }
        System.out.println("Agenda sem espaço!");
    }

    public void excluirContato(int id) {
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i) != null) {
                if (agenda.get(i).getId() == id) {
                    agenda.remove(i);
                    atualizarPrevia();
                    System.out.println("Cadastro excluído com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Contato não encontrado!");
    }
    
    public void exibirContato(int id) {
        if (agenda.get(id) != null) {
            atualizarPrevia();
            System.out.println();
            System.out.println("id: " + agenda.get(id).getId());
            System.out.println("nome: " + agenda.get(id).getName());
            System.out.println("telefone: " + agenda.get(id).getPhone());
            System.out.println("aniversário: " + agenda.get(id).getBirthday());
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public void editarContato(int id, String name, String phone, String birthday) {
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i) != null) {
                if (agenda.get(i).getId() == id) {
                    if (name != null) agenda.get(i).setName(name);
                    if (phone != null) agenda.get(i).setPhone(phone);
                    if (birthday != null) agenda.get(i).setBirthday(birthday);
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
        for (int i=0; i<agenda.size(); i++) {
            System.out.print(i + " - ");
            if (agenda.get(i) != null) {
                System.out.print(agenda.get(i).getName());
            }
            if (i < agenda.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(']');
    }
}
