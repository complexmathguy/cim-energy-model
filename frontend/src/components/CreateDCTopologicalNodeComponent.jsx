import React, { Component } from 'react'
import DCTopologicalNodeService from '../services/DCTopologicalNodeService';

class CreateDCTopologicalNodeComponent extends Component {
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
            DCTopologicalNodeService.getDCTopologicalNodeById(this.state.id).then( (res) =>{
                let dCTopologicalNode = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCTopologicalNode = (e) => {
        e.preventDefault();
        let dCTopologicalNode = {
                dCTopologicalNodeId: this.state.id,
            };
        console.log('dCTopologicalNode => ' + JSON.stringify(dCTopologicalNode));

        // step 5
        if(this.state.id === '_add'){
            dCTopologicalNode.dCTopologicalNodeId=''
            DCTopologicalNodeService.createDCTopologicalNode(dCTopologicalNode).then(res =>{
                this.props.history.push('/dCTopologicalNodes');
            });
        }else{
            DCTopologicalNodeService.updateDCTopologicalNode(dCTopologicalNode).then( res => {
                this.props.history.push('/dCTopologicalNodes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCTopologicalNodes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCTopologicalNode</h3>
        }else{
            return <h3 className="text-center">Update DCTopologicalNode</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCTopologicalNode}>Save</button>
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

export default CreateDCTopologicalNodeComponent
