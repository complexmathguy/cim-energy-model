import React, { Component } from 'react'
import WindTurbineType3or4DynamicsService from '../services/WindTurbineType3or4DynamicsService';

class UpdateWindTurbineType3or4DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindTurbineType3or4Dynamics = this.updateWindTurbineType3or4Dynamics.bind(this);

    }

    componentDidMount(){
        WindTurbineType3or4DynamicsService.getWindTurbineType3or4DynamicsById(this.state.id).then( (res) =>{
            let windTurbineType3or4Dynamics = res.data;
            this.setState({
            });
        });
    }

    updateWindTurbineType3or4Dynamics = (e) => {
        e.preventDefault();
        let windTurbineType3or4Dynamics = {
            windTurbineType3or4DynamicsId: this.state.id,
        };
        console.log('windTurbineType3or4Dynamics => ' + JSON.stringify(windTurbineType3or4Dynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindTurbineType3or4DynamicsService.updateWindTurbineType3or4Dynamics(windTurbineType3or4Dynamics).then( res => {
            this.props.history.push('/windTurbineType3or4Dynamicss');
        });
    }


    cancel(){
        this.props.history.push('/windTurbineType3or4Dynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindTurbineType3or4Dynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindTurbineType3or4Dynamics}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateWindTurbineType3or4DynamicsComponent
