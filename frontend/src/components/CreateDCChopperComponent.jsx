import React, { Component } from 'react'
import DCChopperService from '../services/DCChopperService';

class CreateDCChopperComponent extends Component {
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
            DCChopperService.getDCChopperById(this.state.id).then( (res) =>{
                let dCChopper = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCChopper = (e) => {
        e.preventDefault();
        let dCChopper = {
                dCChopperId: this.state.id,
            };
        console.log('dCChopper => ' + JSON.stringify(dCChopper));

        // step 5
        if(this.state.id === '_add'){
            dCChopper.dCChopperId=''
            DCChopperService.createDCChopper(dCChopper).then(res =>{
                this.props.history.push('/dCChoppers');
            });
        }else{
            DCChopperService.updateDCChopper(dCChopper).then( res => {
                this.props.history.push('/dCChoppers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCChoppers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCChopper</h3>
        }else{
            return <h3 className="text-center">Update DCChopper</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCChopper}>Save</button>
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

export default CreateDCChopperComponent
