import React, { Component } from 'react'
import ENTSOETopologicalNodeService from '../services/ENTSOETopologicalNodeService';

class CreateENTSOETopologicalNodeComponent extends Component {
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
            ENTSOETopologicalNodeService.getENTSOETopologicalNodeById(this.state.id).then( (res) =>{
                let eNTSOETopologicalNode = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateENTSOETopologicalNode = (e) => {
        e.preventDefault();
        let eNTSOETopologicalNode = {
                eNTSOETopologicalNodeId: this.state.id,
            };
        console.log('eNTSOETopologicalNode => ' + JSON.stringify(eNTSOETopologicalNode));

        // step 5
        if(this.state.id === '_add'){
            eNTSOETopologicalNode.eNTSOETopologicalNodeId=''
            ENTSOETopologicalNodeService.createENTSOETopologicalNode(eNTSOETopologicalNode).then(res =>{
                this.props.history.push('/eNTSOETopologicalNodes');
            });
        }else{
            ENTSOETopologicalNodeService.updateENTSOETopologicalNode(eNTSOETopologicalNode).then( res => {
                this.props.history.push('/eNTSOETopologicalNodes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/eNTSOETopologicalNodes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ENTSOETopologicalNode</h3>
        }else{
            return <h3 className="text-center">Update ENTSOETopologicalNode</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateENTSOETopologicalNode}>Save</button>
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

export default CreateENTSOETopologicalNodeComponent
