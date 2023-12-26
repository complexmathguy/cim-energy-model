import React, { Component } from 'react'
import DisconnectorService from '../services/DisconnectorService';

class CreateDisconnectorComponent extends Component {
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
            DisconnectorService.getDisconnectorById(this.state.id).then( (res) =>{
                let disconnector = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDisconnector = (e) => {
        e.preventDefault();
        let disconnector = {
                disconnectorId: this.state.id,
            };
        console.log('disconnector => ' + JSON.stringify(disconnector));

        // step 5
        if(this.state.id === '_add'){
            disconnector.disconnectorId=''
            DisconnectorService.createDisconnector(disconnector).then(res =>{
                this.props.history.push('/disconnectors');
            });
        }else{
            DisconnectorService.updateDisconnector(disconnector).then( res => {
                this.props.history.push('/disconnectors');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/disconnectors');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Disconnector</h3>
        }else{
            return <h3 className="text-center">Update Disconnector</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDisconnector}>Save</button>
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

export default CreateDisconnectorComponent
