import React, { Component } from 'react'
import TieFlowService from '../services/TieFlowService';

class CreateTieFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                positiveFlowIn: ''
        }
        this.changepositiveFlowInHandler = this.changepositiveFlowInHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TieFlowService.getTieFlowById(this.state.id).then( (res) =>{
                let tieFlow = res.data;
                this.setState({
                    positiveFlowIn: tieFlow.positiveFlowIn
                });
            });
        }        
    }
    saveOrUpdateTieFlow = (e) => {
        e.preventDefault();
        let tieFlow = {
                tieFlowId: this.state.id,
                positiveFlowIn: this.state.positiveFlowIn
            };
        console.log('tieFlow => ' + JSON.stringify(tieFlow));

        // step 5
        if(this.state.id === '_add'){
            tieFlow.tieFlowId=''
            TieFlowService.createTieFlow(tieFlow).then(res =>{
                this.props.history.push('/tieFlows');
            });
        }else{
            TieFlowService.updateTieFlow(tieFlow).then( res => {
                this.props.history.push('/tieFlows');
            });
        }
    }
    
    changepositiveFlowInHandler= (event) => {
        this.setState({positiveFlowIn: event.target.value});
    }

    cancel(){
        this.props.history.push('/tieFlows');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TieFlow</h3>
        }else{
            return <h3 className="text-center">Update TieFlow</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> positiveFlowIn: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTieFlow}>Save</button>
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

export default CreateTieFlowComponent
