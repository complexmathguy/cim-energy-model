import React, { Component } from 'react'
import GroundDisconnectorService from '../services/GroundDisconnectorService';

class CreateGroundDisconnectorComponent extends Component {
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
            GroundDisconnectorService.getGroundDisconnectorById(this.state.id).then( (res) =>{
                let groundDisconnector = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGroundDisconnector = (e) => {
        e.preventDefault();
        let groundDisconnector = {
                groundDisconnectorId: this.state.id,
            };
        console.log('groundDisconnector => ' + JSON.stringify(groundDisconnector));

        // step 5
        if(this.state.id === '_add'){
            groundDisconnector.groundDisconnectorId=''
            GroundDisconnectorService.createGroundDisconnector(groundDisconnector).then(res =>{
                this.props.history.push('/groundDisconnectors');
            });
        }else{
            GroundDisconnectorService.updateGroundDisconnector(groundDisconnector).then( res => {
                this.props.history.push('/groundDisconnectors');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/groundDisconnectors');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GroundDisconnector</h3>
        }else{
            return <h3 className="text-center">Update GroundDisconnector</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGroundDisconnector}>Save</button>
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

export default CreateGroundDisconnectorComponent
