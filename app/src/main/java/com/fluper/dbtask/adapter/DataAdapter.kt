package com.passport.employee


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fluper.dbtask.DatabaseClient
import com.fluper.dbtask.ImageActivity
import com.fluper.dbtask.R
import com.fluper.dbtask.ShowProductActivity
import com.fluper.dbtask.database.Product


class DataAdapter// data is passed into the constructor
internal constructor(
    private val context: Context,
    private val mData: List<Product>
) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater


    init {
        this.mInflater = LayoutInflater.from(context)
    }

    // inflates the cell layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.row_list, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each cell
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        try {
            if (mData.get(position).name != null) {

                holder.textName.text =
                    mData.get(position).name.toString()
            }
        } catch (e: Exception) {

        }
        /* try {
             if (mData.get(position).description!= null) {
                 holder.textDesc.text = mData.get(position).description.toString()
             }
         }catch(e:Exception)
         {

         }*/
        try {
            if (mData.get(position).colors != null) {
                holder.textColor.text = mData.get(position).colors.toString()
            }
        } catch (e: Exception) {

        }
        /* try {
             if (mData.get(position).regularPrice != null) {
                 holder.textRPrice.text =  mData.get(position).regularPrice.toString()
             }
         }catch(e:Exception)
         {

         }*/
        try {
            if (mData.get(position).salePrice != null) {
                holder.textSPrice.text = mData.get(position).salePrice.toString()
            }
        } catch (e: Exception) {

        }
        try {
            if (mData.get(position).imageName != null) {
                holder.image.setImageResource(mData.get(position).imageName!!)
                holder.image.setOnClickListener {
                    val intent = Intent(context, ImageActivity::class.java)
                    intent.putExtra("image", mData.get(position).imageName!!)
                    context.startActivity(intent)
                }
            }
        } catch (e: Exception) {

        }
        holder.btnDelete.setOnClickListener {
            DatabaseClient.getInstance(context)!!.appDatabase!!.productDao()!!.delete(
                mData.get(
                    position
                )
            )
            val productListFromDb =
                DatabaseClient.getInstance(context)!!.appDatabase!!.productDao()!!.productList
            ShowProductActivity.loadList(productListFromDb, context)

        }
        holder.btnModify.setOnClickListener {
            val ss: View =
                LayoutInflater.from(context).inflate(R.layout.dialog, null)
            val builderDialog: AlertDialog.Builder = AlertDialog.Builder(context)

            builderDialog.setView(ss)
                .setPositiveButton("Update",
                    DialogInterface.OnClickListener { dialog, which ->
                        val et =
                            ss.findViewById<View>(R.id.editText) as EditText

                        mData.get(position).salePrice = et.text.toString().toDouble()
                        DatabaseClient.getInstance(context)!!.appDatabase!!.productDao()!!.update(
                            mData.get(position)
                        )
                        val productListFromDb =
                            DatabaseClient.getInstance(context)!!.appDatabase!!.productDao()!!.productList
                        ShowProductActivity.loadList(productListFromDb, context)
                    }).setNegativeButton("Cancel", null)
                .setCancelable(false)

            val alert: AlertDialog = builderDialog.create()
            alert.show()


        }
    }

    // total number of cells
    override fun getItemCount(): Int {
        return mData.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        lateinit var textName: TextView
        /* lateinit var textDesc: TextView
         lateinit var textRPrice: TextView*/
        lateinit var textSPrice: TextView
        lateinit var textColor: TextView
        lateinit var image: ImageView
        lateinit var btnDelete: Button
        lateinit var btnModify: Button


        init {
            textName = itemView.findViewById(R.id.tvname) as TextView

            //  textDesc = itemView.findViewById(R.id.tvdes) as TextView

            //   textRPrice = itemView.findViewById(R.id.tvrprice) as TextView
            textSPrice = itemView.findViewById(R.id.tvsprice) as TextView
            textColor = itemView.findViewById(R.id.tvcolors) as TextView
            image = itemView.findViewById(R.id.ivimage) as ImageView
            btnDelete = itemView.findViewById(R.id.btndelete) as Button
            btnModify = itemView.findViewById(R.id.btnmodify) as Button

        }


    }


}