import React, { Component } from 'react'
import DiscontinuousExcitationControlDynamicsService from '../services/DiscontinuousExcitationControlDynamicsService';

class UpdateDiscontinuousExcitationControlDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiscontinuousExcitationControlDynamics = this.updateDiscontinuousExcitationControlDynamics.bind(this);

    }

    componentDidMount(){
        DiscontinuousExcitationControlDynamicsService.getDiscontinuousExcitationControlDynamicsById(this.state.id).then( (res) =>{
            let discontinuousExcitationControlDynamics = res.data;
            this.setState({
            });
        });
    }

    updateDiscontinuousExcitationControlDynamics = (e) => {
        e.preventDefault();
        let discontinuousExcitationControlDynamics = {
            discontinuousExcitationControlDynamicsId: this.state.id,
        };
        console.log('discontinuousExcitationControlDynamics => ' + JSON.stringify(discontinuousExcitationControlDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiscontinuousExcitationControlDynamicsService.updateDiscontinuousExcitationControlDynamics(discontinuousExcitationControlDynamics).then( res => {
            this.props.history.push('/discontinuousExcitationControlDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/discontinuousExcitationControlDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiscontinuousExcitationControlDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiscontinuousExcitationControlDynamics}>Save</button>
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

export default UpdateDiscontinuousExcitationControlDynamicsComponent
