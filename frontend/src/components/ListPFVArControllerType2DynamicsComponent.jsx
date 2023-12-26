import React, { Component } from 'react'
import PFVArControllerType2DynamicsService from '../services/PFVArControllerType2DynamicsService'

class ListPFVArControllerType2DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArControllerType2Dynamicss: []
        }
        this.addPFVArControllerType2Dynamics = this.addPFVArControllerType2Dynamics.bind(this);
        this.editPFVArControllerType2Dynamics = this.editPFVArControllerType2Dynamics.bind(this);
        this.deletePFVArControllerType2Dynamics = this.deletePFVArControllerType2Dynamics.bind(this);
    }

    deletePFVArControllerType2Dynamics(id){
        PFVArControllerType2DynamicsService.deletePFVArControllerType2Dynamics(id).then( res => {
            this.setState({pFVArControllerType2Dynamicss: this.state.pFVArControllerType2Dynamicss.filter(pFVArControllerType2Dynamics => pFVArControllerType2Dynamics.pFVArControllerType2DynamicsId !== id)});
        });
    }
    viewPFVArControllerType2Dynamics(id){
        this.props.history.push(`/view-pFVArControllerType2Dynamics/${id}`);
    }
    editPFVArControllerType2Dynamics(id){
        this.props.history.push(`/add-pFVArControllerType2Dynamics/${id}`);
    }

    componentDidMount(){
        PFVArControllerType2DynamicsService.getPFVArControllerType2Dynamicss().then((res) => {
            this.setState({ pFVArControllerType2Dynamicss: res.data});
        });
    }

    addPFVArControllerType2Dynamics(){
        this.props.history.push('/add-pFVArControllerType2Dynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArControllerType2Dynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArControllerType2Dynamics}> Add PFVArControllerType2Dynamics</button>
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
                                    this.state.pFVArControllerType2Dynamicss.map(
                                        pFVArControllerType2Dynamics => 
                                        <tr key = {pFVArControllerType2Dynamics.pFVArControllerType2DynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editPFVArControllerType2Dynamics(pFVArControllerType2Dynamics.pFVArControllerType2DynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArControllerType2Dynamics(pFVArControllerType2Dynamics.pFVArControllerType2DynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArControllerType2Dynamics(pFVArControllerType2Dynamics.pFVArControllerType2DynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArControllerType2DynamicsComponent
