import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

public class RetroFit {
    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TesteApi api = retrofit.create(TesteApi.class);

        //- Post -//
        try {
            Tarefas task = new Tarefas();

            task.setDescricao("Rodrigo Peruzzo");
            Call<Tarefas> call = api.postTarefas(task);

            Response<Tarefas> r = call.execute();

            Tarefas t = r.body();

        System.out.println(t);

    } catch (Exception e) {
        e.printStackTrace();
    }


        //- Get -//
        try {
            Call<List<Tarefas>> call = api.getTarefas();

            Response<List<Tarefas>> r = call.execute();

            List<Tarefas> t = r.body();

            System.out.println(t);

        } catch (Exception e) {
            e.printStackTrace();
        }


        //- Get ID -//

        try {
            Tarefas task = new Tarefas();

            Call<Tarefas> call = api.getTarefasId("30");

            Response<Tarefas> r = call.execute();

            Tarefas t = r.body();

            System.out.println(t);

        } catch (Exception e) {
            e.printStackTrace();
        }

		//- Delete -//
        try {

            Call<Void> call = api.delete("30");
            Response<Void> r = call.execute();
            r.isSuccessful();
            if (r.isSuccessful()) {
                System.out.println("Task deleted");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

		//- Put -//
        try {
            Tarefas tarefas = new Tarefas();
            tarefas.setId("30");
            tarefas.setDescricao("Put");
            tarefas.setDone(true);

            Call<Void> call = api.update(tarefas.getId(), tarefas);

            Response<Void> r = call.execute();
            r.isSuccessful();
            if (r.isSuccessful()) {
                System.out.println("Task atualizada");
            } else {
                System.out.println("Task não encontrada");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
