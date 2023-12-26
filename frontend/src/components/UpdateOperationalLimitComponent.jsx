import React, { Component } from 'react'
import OperationalLimitService from '../services/OperationalLimitService';

class UpdateOperationalLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateOperationalLimit = this.updateOperationalLimit.bind(this);

    }

    componentDidMount(){
        OperationalLimitService.getOperationalLimitById(this.state.id).then( (res) =>{
            let operationalLimit = res.data;
            this.setState({
            });
        });
    }

    updateOperationalLimit = (e) => {
        e.preventDefault();
        let operationalLimit = {
            operationalLimitId: this.state.id,
        };
        console.log('operationalLimit => ' + JSON.stringify(operationalLimit));
        console.log('id => ' + JSON.stringify(this.state.id));
        OperationalLimitService.updateOperationalLimit(operationalLimit).then( res => {
            this.props.history.push('/operationalLimits');
        });
    }


    cancel(){
        this.props.history.push('/operationalLimits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OperationalLimit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOperationalLimit}>Save</button>
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

export default UpdateOperationalLimitComponent
