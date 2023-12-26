import React, { Component } from 'react'
import LoadAreaService from '../services/LoadAreaService'

class ListLoadAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadAreas: []
        }
        this.addLoadArea = this.addLoadArea.bind(this);
        this.editLoadArea = this.editLoadArea.bind(this);
        this.deleteLoadArea = this.deleteLoadArea.bind(this);
    }

    deleteLoadArea(id){
        LoadAreaService.deleteLoadArea(id).then( res => {
            this.setState({loadAreas: this.state.loadAreas.filter(loadArea => loadArea.loadAreaId !== id)});
        });
    }
    viewLoadArea(id){
        this.props.history.push(`/view-loadArea/${id}`);
    }
    editLoadArea(id){
        this.props.history.push(`/add-loadArea/${id}`);
    }

    componentDidMount(){
        LoadAreaService.getLoadAreas().then((res) => {
            this.setState({ loadAreas: res.data});
        });
    }

    addLoadArea(){
        this.props.history.push('/add-loadArea/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadArea List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadArea}> Add LoadArea</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.loadAreas.map(
                                        loadArea => 
                                        <tr key = {loadArea.loadAreaId}>
                                             <td>
                                                 <button onClick={ () => this.editLoadArea(loadArea.loadAreaId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadArea(loadArea.loadAreaId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadArea(loadArea.loadAreaId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListLoadAreaComponent
