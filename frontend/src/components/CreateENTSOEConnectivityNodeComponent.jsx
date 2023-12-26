import React, { Component } from 'react'
import ENTSOEConnectivityNodeService from '../services/ENTSOEConnectivityNodeService';

class CreateENTSOEConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ENTSOEConnectivityNodeService.getENTSOEConnectivityNodeById(this.state.id).then( (res) =>{
                let eNTSOEConnectivityNode = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateENTSOEConnectivityNode = (e) => {
        e.preventDefault();
        let eNTSOEConnectivityNode = {
                eNTSOEConnectivityNodeId: this.state.id,
            };
        console.log('eNTSOEConnectivityNode => ' + JSON.stringify(eNTSOEConnectivityNode));

        // step 5
        if(this.state.id === '_add'){
            eNTSOEConnectivityNode.eNTSOEConnectivityNodeId=''
            ENTSOEConnectivityNodeService.createENTSOEConnectivityNode(eNTSOEConnectivityNode).then(res =>{
                this.props.history.push('/eNTSOEConnectivityNodes');
            });
        }else{
            ENTSOEConnectivityNodeService.updateENTSOEConnectivityNode(eNTSOEConnectivityNode).then( res => {
                this.props.history.push('/eNTSOEConnectivityNodes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/eNTSOEConnectivityNodes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ENTSOEConnectivityNode</h3>
        }else{
            return <h3 className="text-center">Update ENTSOEConnectivityNode</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateENTSOEConnectivityNode}>Save</button>
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

export default CreateENTSOEConnectivityNodeComponent
