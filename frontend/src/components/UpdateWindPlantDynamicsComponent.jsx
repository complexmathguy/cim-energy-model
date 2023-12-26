import React, { Component } from 'react'
import WindPlantDynamicsService from '../services/WindPlantDynamicsService';

class UpdateWindPlantDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindPlantDynamics = this.updateWindPlantDynamics.bind(this);

    }

    componentDidMount(){
        WindPlantDynamicsService.getWindPlantDynamicsById(this.state.id).then( (res) =>{
            let windPlantDynamics = res.data;
            this.setState({
            });
        });
    }

    updateWindPlantDynamics = (e) => {
        e.preventDefault();
        let windPlantDynamics = {
            windPlantDynamicsId: this.state.id,
        };
        console.log('windPlantDynamics => ' + JSON.stringify(windPlantDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPlantDynamicsService.updateWindPlantDynamics(windPlantDynamics).then( res => {
            this.props.history.push('/windPlantDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/windPlantDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPlantDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPlantDynamics}>Save</button>
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

export default UpdateWindPlantDynamicsComponent
