import React, { Component } from 'react'
import DynamicsmodelService from '../services/DynamicsmodelService'

class ListDynamicsmodelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dynamicsmodels: []
        }
        this.addDynamicsmodel = this.addDynamicsmodel.bind(this);
        this.editDynamicsmodel = this.editDynamicsmodel.bind(this);
        this.deleteDynamicsmodel = this.deleteDynamicsmodel.bind(this);
    }

    deleteDynamicsmodel(id){
        DynamicsmodelService.deleteDynamicsmodel(id).then( res => {
            this.setState({dynamicsmodels: this.state.dynamicsmodels.filter(dynamicsmodel => dynamicsmodel.dynamicsmodelId !== id)});
        });
    }
    viewDynamicsmodel(id){
        this.props.history.push(`/view-dynamicsmodel/${id}`);
    }
    editDynamicsmodel(id){
        this.props.history.push(`/add-dynamicsmodel/${id}`);
    }

    componentDidMount(){
        DynamicsmodelService.getDynamicsmodels().then((res) => {
            this.setState({ dynamicsmodels: res.data});
        });
    }

    addDynamicsmodel(){
        this.props.history.push('/add-dynamicsmodel/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Dynamicsmodel List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDynamicsmodel}> Add Dynamicsmodel</button>
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
                                    this.state.dynamicsmodels.map(
                                        dynamicsmodel => 
                                        <tr key = {dynamicsmodel.dynamicsmodelId}>
                                             <td>
                                                 <button onClick={ () => this.editDynamicsmodel(dynamicsmodel.dynamicsmodelId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDynamicsmodel(dynamicsmodel.dynamicsmodelId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDynamicsmodel(dynamicsmodel.dynamicsmodelId)} className="btn btn-info btn-sm">View </button>
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

export default ListDynamicsmodelComponent
