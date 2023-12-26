import React, { Component } from 'react'
import SvPowerFlowService from '../services/SvPowerFlowService';

class CreateSvPowerFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                p: '',
                q: ''
        }
        this.changepHandler = this.changepHandler.bind(this);
        this.changeqHandler = this.changeqHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SvPowerFlowService.getSvPowerFlowById(this.state.id).then( (res) =>{
                let svPowerFlow = res.data;
                this.setState({
                    p: svPowerFlow.p,
                    q: svPowerFlow.q
                });
            });
        }        
    }
    saveOrUpdateSvPowerFlow = (e) => {
        e.preventDefault();
        let svPowerFlow = {
                svPowerFlowId: this.state.id,
                p: this.state.p,
                q: this.state.q
            };
        console.log('svPowerFlow => ' + JSON.stringify(svPowerFlow));

        // step 5
        if(this.state.id === '_add'){
            svPowerFlow.svPowerFlowId=''
            SvPowerFlowService.createSvPowerFlow(svPowerFlow).then(res =>{
                this.props.history.push('/svPowerFlows');
            });
        }else{
            SvPowerFlowService.updateSvPowerFlow(svPowerFlow).then( res => {
                this.props.history.push('/svPowerFlows');
            });
        }
    }
    
    changepHandler= (event) => {
        this.setState({p: event.target.value});
    }
    changeqHandler= (event) => {
        this.setState({q: event.target.value});
    }

    cancel(){
        this.props.history.push('/svPowerFlows');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SvPowerFlow</h3>
        }else{
            return <h3 className="text-center">Update SvPowerFlow</h3>
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
                                            <label> p: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSvPowerFlow}>Save</button>
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

export default CreateSvPowerFlowComponent
