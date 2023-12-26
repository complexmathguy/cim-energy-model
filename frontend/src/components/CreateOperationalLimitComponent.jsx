import React, { Component } from 'react'
import OperationalLimitService from '../services/OperationalLimitService';

class CreateOperationalLimitComponent extends Component {
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
            OperationalLimitService.getOperationalLimitById(this.state.id).then( (res) =>{
                let operationalLimit = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateOperationalLimit = (e) => {
        e.preventDefault();
        let operationalLimit = {
                operationalLimitId: this.state.id,
            };
        console.log('operationalLimit => ' + JSON.stringify(operationalLimit));

        // step 5
        if(this.state.id === '_add'){
            operationalLimit.operationalLimitId=''
            OperationalLimitService.createOperationalLimit(operationalLimit).then(res =>{
                this.props.history.push('/operationalLimits');
            });
        }else{
            OperationalLimitService.updateOperationalLimit(operationalLimit).then( res => {
                this.props.history.push('/operationalLimits');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/operationalLimits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OperationalLimit</h3>
        }else{
            return <h3 className="text-center">Update OperationalLimit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOperationalLimit}>Save</button>
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

export default CreateOperationalLimitComponent
