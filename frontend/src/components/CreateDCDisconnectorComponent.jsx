import React, { Component } from 'react'
import DCDisconnectorService from '../services/DCDisconnectorService';

class CreateDCDisconnectorComponent extends Component {
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
            DCDisconnectorService.getDCDisconnectorById(this.state.id).then( (res) =>{
                let dCDisconnector = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCDisconnector = (e) => {
        e.preventDefault();
        let dCDisconnector = {
                dCDisconnectorId: this.state.id,
            };
        console.log('dCDisconnector => ' + JSON.stringify(dCDisconnector));

        // step 5
        if(this.state.id === '_add'){
            dCDisconnector.dCDisconnectorId=''
            DCDisconnectorService.createDCDisconnector(dCDisconnector).then(res =>{
                this.props.history.push('/dCDisconnectors');
            });
        }else{
            DCDisconnectorService.updateDCDisconnector(dCDisconnector).then( res => {
                this.props.history.push('/dCDisconnectors');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCDisconnectors');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCDisconnector</h3>
        }else{
            return <h3 className="text-center">Update DCDisconnector</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCDisconnector}>Save</button>
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

export default CreateDCDisconnectorComponent
