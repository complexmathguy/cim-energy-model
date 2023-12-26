import React, { Component } from 'react'
import DCNodeService from '../services/DCNodeService';

class CreateDCNodeComponent extends Component {
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
            DCNodeService.getDCNodeById(this.state.id).then( (res) =>{
                let dCNode = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCNode = (e) => {
        e.preventDefault();
        let dCNode = {
                dCNodeId: this.state.id,
            };
        console.log('dCNode => ' + JSON.stringify(dCNode));

        // step 5
        if(this.state.id === '_add'){
            dCNode.dCNodeId=''
            DCNodeService.createDCNode(dCNode).then(res =>{
                this.props.history.push('/dCNodes');
            });
        }else{
            DCNodeService.updateDCNode(dCNode).then( res => {
                this.props.history.push('/dCNodes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCNodes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCNode</h3>
        }else{
            return <h3 className="text-center">Update DCNode</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCNode}>Save</button>
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

export default CreateDCNodeComponent
