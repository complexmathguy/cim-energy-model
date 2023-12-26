import React, { Component } from 'react'
import PFVArControllerType1DynamicsService from '../services/PFVArControllerType1DynamicsService'

class ListPFVArControllerType1DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArControllerType1Dynamicss: []
        }
        this.addPFVArControllerType1Dynamics = this.addPFVArControllerType1Dynamics.bind(this);
        this.editPFVArControllerType1Dynamics = this.editPFVArControllerType1Dynamics.bind(this);
        this.deletePFVArControllerType1Dynamics = this.deletePFVArControllerType1Dynamics.bind(this);
    }

    deletePFVArControllerType1Dynamics(id){
        PFVArControllerType1DynamicsService.deletePFVArControllerType1Dynamics(id).then( res => {
            this.setState({pFVArControllerType1Dynamicss: this.state.pFVArControllerType1Dynamicss.filter(pFVArControllerType1Dynamics => pFVArControllerType1Dynamics.pFVArControllerType1DynamicsId !== id)});
        });
    }
    viewPFVArControllerType1Dynamics(id){
        this.props.history.push(`/view-pFVArControllerType1Dynamics/${id}`);
    }
    editPFVArControllerType1Dynamics(id){
        this.props.history.push(`/add-pFVArControllerType1Dynamics/${id}`);
    }

    componentDidMount(){
        PFVArControllerType1DynamicsService.getPFVArControllerType1Dynamicss().then((res) => {
            this.setState({ pFVArControllerType1Dynamicss: res.data});
        });
    }

    addPFVArControllerType1Dynamics(){
        this.props.history.push('/add-pFVArControllerType1Dynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArControllerType1Dynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArControllerType1Dynamics}> Add PFVArControllerType1Dynamics</button>
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
                                    this.state.pFVArControllerType1Dynamicss.map(
                                        pFVArControllerType1Dynamics => 
                                        <tr key = {pFVArControllerType1Dynamics.pFVArControllerType1DynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editPFVArControllerType1Dynamics(pFVArControllerType1Dynamics.pFVArControllerType1DynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArControllerType1Dynamics(pFVArControllerType1Dynamics.pFVArControllerType1DynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArControllerType1Dynamics(pFVArControllerType1Dynamics.pFVArControllerType1DynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArControllerType1DynamicsComponent
