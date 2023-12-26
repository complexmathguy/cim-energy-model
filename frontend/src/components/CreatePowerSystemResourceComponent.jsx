import React, { Component } from 'react'
import PowerSystemResourceService from '../services/PowerSystemResourceService';

class CreatePowerSystemResourceComponent extends Component {
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
            PowerSystemResourceService.getPowerSystemResourceById(this.state.id).then( (res) =>{
                let powerSystemResource = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePowerSystemResource = (e) => {
        e.preventDefault();
        let powerSystemResource = {
                powerSystemResourceId: this.state.id,
            };
        console.log('powerSystemResource => ' + JSON.stringify(powerSystemResource));

        // step 5
        if(this.state.id === '_add'){
            powerSystemResource.powerSystemResourceId=''
            PowerSystemResourceService.createPowerSystemResource(powerSystemResource).then(res =>{
                this.props.history.push('/powerSystemResources');
            });
        }else{
            PowerSystemResourceService.updatePowerSystemResource(powerSystemResource).then( res => {
                this.props.history.push('/powerSystemResources');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/powerSystemResources');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PowerSystemResource</h3>
        }else{
            return <h3 className="text-center">Update PowerSystemResource</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePowerSystemResource}>Save</button>
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

export default CreatePowerSystemResourceComponent
