import React, { Component } from 'react'
import DCChopperService from '../services/DCChopperService';

class UpdateDCChopperComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCChopper = this.updateDCChopper.bind(this);

    }

    componentDidMount(){
        DCChopperService.getDCChopperById(this.state.id).then( (res) =>{
            let dCChopper = res.data;
            this.setState({
            });
        });
    }

    updateDCChopper = (e) => {
        e.preventDefault();
        let dCChopper = {
            dCChopperId: this.state.id,
        };
        console.log('dCChopper => ' + JSON.stringify(dCChopper));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCChopperService.updateDCChopper(dCChopper).then( res => {
            this.props.history.push('/dCChoppers');
        });
    }


    cancel(){
        this.props.history.push('/dCChoppers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCChopper</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCChopper}>Save</button>
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

export default UpdateDCChopperComponent
