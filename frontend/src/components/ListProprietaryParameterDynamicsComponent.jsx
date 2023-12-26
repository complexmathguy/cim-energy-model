import React, { Component } from 'react'
import ProprietaryParameterDynamicsService from '../services/ProprietaryParameterDynamicsService'

class ListProprietaryParameterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                proprietaryParameterDynamicss: []
        }
        this.addProprietaryParameterDynamics = this.addProprietaryParameterDynamics.bind(this);
        this.editProprietaryParameterDynamics = this.editProprietaryParameterDynamics.bind(this);
        this.deleteProprietaryParameterDynamics = this.deleteProprietaryParameterDynamics.bind(this);
    }

    deleteProprietaryParameterDynamics(id){
        ProprietaryParameterDynamicsService.deleteProprietaryParameterDynamics(id).then( res => {
            this.setState({proprietaryParameterDynamicss: this.state.proprietaryParameterDynamicss.filter(proprietaryParameterDynamics => proprietaryParameterDynamics.proprietaryParameterDynamicsId !== id)});
        });
    }
    viewProprietaryParameterDynamics(id){
        this.props.history.push(`/view-proprietaryParameterDynamics/${id}`);
    }
    editProprietaryParameterDynamics(id){
        this.props.history.push(`/add-proprietaryParameterDynamics/${id}`);
    }

    componentDidMount(){
        ProprietaryParameterDynamicsService.getProprietaryParameterDynamicss().then((res) => {
            this.setState({ proprietaryParameterDynamicss: res.data});
        });
    }

    addProprietaryParameterDynamics(){
        this.props.history.push('/add-proprietaryParameterDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ProprietaryParameterDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addProprietaryParameterDynamics}> Add ProprietaryParameterDynamics</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> BooleanParameterValue </th>
                                    <th> FloatParameterValue </th>
                                    <th> IntegerParameterValue </th>
                                    <th> ParameterNumber </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.proprietaryParameterDynamicss.map(
                                        proprietaryParameterDynamics => 
                                        <tr key = {proprietaryParameterDynamics.proprietaryParameterDynamicsId}>
                                             <td> { proprietaryParameterDynamics.booleanParameterValue } </td>
                                             <td> { proprietaryParameterDynamics.floatParameterValue } </td>
                                             <td> { proprietaryParameterDynamics.integerParameterValue } </td>
                                             <td> { proprietaryParameterDynamics.parameterNumber } </td>
                                             <td>
                                                 <button onClick={ () => this.editProprietaryParameterDynamics(proprietaryParameterDynamics.proprietaryParameterDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteProprietaryParameterDynamics(proprietaryParameterDynamics.proprietaryParameterDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewProprietaryParameterDynamics(proprietaryParameterDynamics.proprietaryParameterDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListProprietaryParameterDynamicsComponent
