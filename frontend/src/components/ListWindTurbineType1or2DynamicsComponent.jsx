import React, { Component } from 'react'
import WindTurbineType1or2DynamicsService from '../services/WindTurbineType1or2DynamicsService'

class ListWindTurbineType1or2DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windTurbineType1or2Dynamicss: []
        }
        this.addWindTurbineType1or2Dynamics = this.addWindTurbineType1or2Dynamics.bind(this);
        this.editWindTurbineType1or2Dynamics = this.editWindTurbineType1or2Dynamics.bind(this);
        this.deleteWindTurbineType1or2Dynamics = this.deleteWindTurbineType1or2Dynamics.bind(this);
    }

    deleteWindTurbineType1or2Dynamics(id){
        WindTurbineType1or2DynamicsService.deleteWindTurbineType1or2Dynamics(id).then( res => {
            this.setState({windTurbineType1or2Dynamicss: this.state.windTurbineType1or2Dynamicss.filter(windTurbineType1or2Dynamics => windTurbineType1or2Dynamics.windTurbineType1or2DynamicsId !== id)});
        });
    }
    viewWindTurbineType1or2Dynamics(id){
        this.props.history.push(`/view-windTurbineType1or2Dynamics/${id}`);
    }
    editWindTurbineType1or2Dynamics(id){
        this.props.history.push(`/add-windTurbineType1or2Dynamics/${id}`);
    }

    componentDidMount(){
        WindTurbineType1or2DynamicsService.getWindTurbineType1or2Dynamicss().then((res) => {
            this.setState({ windTurbineType1or2Dynamicss: res.data});
        });
    }

    addWindTurbineType1or2Dynamics(){
        this.props.history.push('/add-windTurbineType1or2Dynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindTurbineType1or2Dynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindTurbineType1or2Dynamics}> Add WindTurbineType1or2Dynamics</button>
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
                                    this.state.windTurbineType1or2Dynamicss.map(
                                        windTurbineType1or2Dynamics => 
                                        <tr key = {windTurbineType1or2Dynamics.windTurbineType1or2DynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editWindTurbineType1or2Dynamics(windTurbineType1or2Dynamics.windTurbineType1or2DynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindTurbineType1or2Dynamics(windTurbineType1or2Dynamics.windTurbineType1or2DynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindTurbineType1or2Dynamics(windTurbineType1or2Dynamics.windTurbineType1or2DynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindTurbineType1or2DynamicsComponent
