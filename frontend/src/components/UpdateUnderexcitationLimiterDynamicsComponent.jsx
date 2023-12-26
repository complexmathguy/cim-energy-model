import React, { Component } from 'react'
import UnderexcitationLimiterDynamicsService from '../services/UnderexcitationLimiterDynamicsService';

class UpdateUnderexcitationLimiterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateUnderexcitationLimiterDynamics = this.updateUnderexcitationLimiterDynamics.bind(this);

    }

    componentDidMount(){
        UnderexcitationLimiterDynamicsService.getUnderexcitationLimiterDynamicsById(this.state.id).then( (res) =>{
            let underexcitationLimiterDynamics = res.data;
            this.setState({
            });
        });
    }

    updateUnderexcitationLimiterDynamics = (e) => {
        e.preventDefault();
        let underexcitationLimiterDynamics = {
            underexcitationLimiterDynamicsId: this.state.id,
        };
        console.log('underexcitationLimiterDynamics => ' + JSON.stringify(underexcitationLimiterDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcitationLimiterDynamicsService.updateUnderexcitationLimiterDynamics(underexcitationLimiterDynamics).then( res => {
            this.props.history.push('/underexcitationLimiterDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/underexcitationLimiterDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcitationLimiterDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcitationLimiterDynamics}>Save</button>
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

export default UpdateUnderexcitationLimiterDynamicsComponent
