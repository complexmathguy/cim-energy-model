import React, { Component } from 'react'
import LoadDynamicsService from '../services/LoadDynamicsService'

class ListLoadDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadDynamicss: []
        }
        this.addLoadDynamics = this.addLoadDynamics.bind(this);
        this.editLoadDynamics = this.editLoadDynamics.bind(this);
        this.deleteLoadDynamics = this.deleteLoadDynamics.bind(this);
    }

    deleteLoadDynamics(id){
        LoadDynamicsService.deleteLoadDynamics(id).then( res => {
            this.setState({loadDynamicss: this.state.loadDynamicss.filter(loadDynamics => loadDynamics.loadDynamicsId !== id)});
        });
    }
    viewLoadDynamics(id){
        this.props.history.push(`/view-loadDynamics/${id}`);
    }
    editLoadDynamics(id){
        this.props.history.push(`/add-loadDynamics/${id}`);
    }

    componentDidMount(){
        LoadDynamicsService.getLoadDynamicss().then((res) => {
            this.setState({ loadDynamicss: res.data});
        });
    }

    addLoadDynamics(){
        this.props.history.push('/add-loadDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadDynamics}> Add LoadDynamics</button>
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
                                    this.state.loadDynamicss.map(
                                        loadDynamics => 
                                        <tr key = {loadDynamics.loadDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editLoadDynamics(loadDynamics.loadDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadDynamics(loadDynamics.loadDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadDynamics(loadDynamics.loadDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadDynamicsComponent
