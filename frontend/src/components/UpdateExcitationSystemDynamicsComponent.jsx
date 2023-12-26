import React, { Component } from 'react'
import ExcitationSystemDynamicsService from '../services/ExcitationSystemDynamicsService';

class UpdateExcitationSystemDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcitationSystemDynamics = this.updateExcitationSystemDynamics.bind(this);

    }

    componentDidMount(){
        ExcitationSystemDynamicsService.getExcitationSystemDynamicsById(this.state.id).then( (res) =>{
            let excitationSystemDynamics = res.data;
            this.setState({
            });
        });
    }

    updateExcitationSystemDynamics = (e) => {
        e.preventDefault();
        let excitationSystemDynamics = {
            excitationSystemDynamicsId: this.state.id,
        };
        console.log('excitationSystemDynamics => ' + JSON.stringify(excitationSystemDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcitationSystemDynamicsService.updateExcitationSystemDynamics(excitationSystemDynamics).then( res => {
            this.props.history.push('/excitationSystemDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/excitationSystemDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcitationSystemDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcitationSystemDynamics}>Save</button>
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

export default UpdateExcitationSystemDynamicsComponent
