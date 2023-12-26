import React, { Component } from 'react'
import WindTurbineType3or4DynamicsService from '../services/WindTurbineType3or4DynamicsService'

class ListWindTurbineType3or4DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windTurbineType3or4Dynamicss: []
        }
        this.addWindTurbineType3or4Dynamics = this.addWindTurbineType3or4Dynamics.bind(this);
        this.editWindTurbineType3or4Dynamics = this.editWindTurbineType3or4Dynamics.bind(this);
        this.deleteWindTurbineType3or4Dynamics = this.deleteWindTurbineType3or4Dynamics.bind(this);
    }

    deleteWindTurbineType3or4Dynamics(id){
        WindTurbineType3or4DynamicsService.deleteWindTurbineType3or4Dynamics(id).then( res => {
            this.setState({windTurbineType3or4Dynamicss: this.state.windTurbineType3or4Dynamicss.filter(windTurbineType3or4Dynamics => windTurbineType3or4Dynamics.windTurbineType3or4DynamicsId !== id)});
        });
    }
    viewWindTurbineType3or4Dynamics(id){
        this.props.history.push(`/view-windTurbineType3or4Dynamics/${id}`);
    }
    editWindTurbineType3or4Dynamics(id){
        this.props.history.push(`/add-windTurbineType3or4Dynamics/${id}`);
    }

    componentDidMount(){
        WindTurbineType3or4DynamicsService.getWindTurbineType3or4Dynamicss().then((res) => {
            this.setState({ windTurbineType3or4Dynamicss: res.data});
        });
    }

    addWindTurbineType3or4Dynamics(){
        this.props.history.push('/add-windTurbineType3or4Dynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindTurbineType3or4Dynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindTurbineType3or4Dynamics}> Add WindTurbineType3or4Dynamics</button>
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
                                    this.state.windTurbineType3or4Dynamicss.map(
                                        windTurbineType3or4Dynamics => 
                                        <tr key = {windTurbineType3or4Dynamics.windTurbineType3or4DynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editWindTurbineType3or4Dynamics(windTurbineType3or4Dynamics.windTurbineType3or4DynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindTurbineType3or4Dynamics(windTurbineType3or4Dynamics.windTurbineType3or4DynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindTurbineType3or4Dynamics(windTurbineType3or4Dynamics.windTurbineType3or4DynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindTurbineType3or4DynamicsComponent
