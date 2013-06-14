package com.pechhetti.expandablelistdemo;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author SACHIN PECHHETTI
 */
public class ExpListAdapter extends BaseExpandableListAdapter implements OnGroupClickListener {

	Context mContext;
	String[] mArrGroupelements;
	String[][] mArrChildelements;

	public ExpListAdapter(Context context, String[] mArrGroupelements, String[][] mArrChildelements) {
		mContext = context;
		this.mArrGroupelements = mArrGroupelements;
		this.mArrChildelements = mArrChildelements;
	}

	@Override
	public int getGroupCount() {
		return mArrGroupelements.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return mArrChildelements[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupPosition;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		TextView tv = (TextView) convertView;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			tv = (TextView) inflater.inflate(R.layout.list_cell, null);
		}
		tv.setText(mArrGroupelements[groupPosition]);
		convertView = tv;
		return convertView;
	}

	@Override
	public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		GridView container = null;
		if (convertView == null) {
			container = (GridView) LayoutInflater.from(mContext).inflate(R.layout.child_grid_view,
	                parent, false);
			
		}else{
			container = (GridView) convertView;
		}
		BaseAdapter mAdapter = new BaseAdapter() {

			
			@Override
			public int getCount() {
				return dataObjects.length;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_thumb, null);
				TextView title = (TextView) retval.findViewById(R.id.image_description);
				
				//title.setText(mArrChildelements[groupPosition][position]);
				title.setText(dataObjects[position]);
				ImageView image = (ImageView)retval.findViewById(R.id.image);
				image.setImageResource(mThumbIds[position]);
				return retval;
			}
			
		};
		//HorizontalListView listview = (HorizontalListView) container.findViewById(R.id.child_list);
		//listview.setAdapter(mAdapter);
		container.setAdapter(mAdapter);
		convertView = container;
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	private static String[] dataObjects = new String[]{ "Text #1",
		"Text #2",
		"Text #3" ,"Text #4","Text #4","Text #4","Text #4","Text #4","Text #4","Text #4","Text #4" };
	private Integer[] mThumbIds = {
    		R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher
    };
	
	@Override
	public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition,
	        long id) {
	    // Implement this method to scroll to the correct position as this doesn't
	    // happen automatically if we override onGroupExpand() as above
	    parent.smoothScrollToPosition(groupPosition);

	    // Need default behaviour here otherwise group does not get expanded/collapsed
	    // on click
	    if (parent.isGroupExpanded(groupPosition)) {
	        parent.collapseGroup(groupPosition);
	    } else {
	        parent.expandGroup(groupPosition);
	    }

	    return true;
	}

	
}
