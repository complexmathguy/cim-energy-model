import React, { Component } from 'react'
import TieFlowService from '../services/TieFlowService';

class UpdateTieFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                positiveFlowIn: ''
        }
        this.updateTieFlow = this.updateTieFlow.bind(this);

        this.changepositiveFlowInHandler = this.changepositiveFlowInHandler.bind(this);
    }

    componentDidMount(){
        TieFlowService.getTieFlowById(this.state.id).then( (res) =>{
            let tieFlow = res.data;
            this.setState({
                positiveFlowIn: tieFlow.positiveFlowIn
            });
        });
    }

    updateTieFlow = (e) => {
        e.preventDefault();
        let tieFlow = {
            tieFlowId: this.state.id,
            positiveFlowIn: this.state.positiveFlowIn
        };
        console.log('tieFlow => ' + JSON.stringify(tieFlow));
        console.log('id => ' + JSON.stringify(this.state.id));
        TieFlowService.updateTieFlow(tieFlow).then( res => {
            this.props.history.push('/tieFlows');
        });
    }

    changepositiveFlowInHandler= (event) => {
        this.setState({positiveFlowIn: event.target.value});
    }

    cancel(){
        this.props.history.push('/tieFlows');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TieFlow</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> positiveFlowIn: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTieFlow}>Save</button>
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

export default UpdateTieFlowComponent
