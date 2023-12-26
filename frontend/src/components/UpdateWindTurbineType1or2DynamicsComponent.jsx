import React, { Component } from 'react'
import WindTurbineType1or2DynamicsService from '../services/WindTurbineType1or2DynamicsService';

class UpdateWindTurbineType1or2DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindTurbineType1or2Dynamics = this.updateWindTurbineType1or2Dynamics.bind(this);

    }

    componentDidMount(){
        WindTurbineType1or2DynamicsService.getWindTurbineType1or2DynamicsById(this.state.id).then( (res) =>{
            let windTurbineType1or2Dynamics = res.data;
            this.setState({
            });
        });
    }

    updateWindTurbineType1or2Dynamics = (e) => {
        e.preventDefault();
        let windTurbineType1or2Dynamics = {
            windTurbineType1or2DynamicsId: this.state.id,
        };
        console.log('windTurbineType1or2Dynamics => ' + JSON.stringify(windTurbineType1or2Dynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindTurbineType1or2DynamicsService.updateWindTurbineType1or2Dynamics(windTurbineType1or2Dynamics).then( res => {
            this.props.history.push('/windTurbineType1or2Dynamicss');
        });
    }


    cancel(){
        this.props.history.push('/windTurbineType1or2Dynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindTurbineType1or2Dynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindTurbineType1or2Dynamics}>Save</button>
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

export default UpdateWindTurbineType1or2DynamicsComponent
