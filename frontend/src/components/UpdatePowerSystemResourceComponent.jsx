import React, { Component } from 'react'
import PowerSystemResourceService from '../services/PowerSystemResourceService';

class UpdatePowerSystemResourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePowerSystemResource = this.updatePowerSystemResource.bind(this);

    }

    componentDidMount(){
        PowerSystemResourceService.getPowerSystemResourceById(this.state.id).then( (res) =>{
            let powerSystemResource = res.data;
            this.setState({
            });
        });
    }

    updatePowerSystemResource = (e) => {
        e.preventDefault();
        let powerSystemResource = {
            powerSystemResourceId: this.state.id,
        };
        console.log('powerSystemResource => ' + JSON.stringify(powerSystemResource));
        console.log('id => ' + JSON.stringify(this.state.id));
        PowerSystemResourceService.updatePowerSystemResource(powerSystemResource).then( res => {
            this.props.history.push('/powerSystemResources');
        });
    }


    cancel(){
        this.props.history.push('/powerSystemResources');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PowerSystemResource</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePowerSystemResource}>Save</button>
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

export default UpdatePowerSystemResourceComponent
