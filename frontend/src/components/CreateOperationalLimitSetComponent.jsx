import React, { Component } from 'react'
import OperationalLimitSetService from '../services/OperationalLimitSetService';

class CreateOperationalLimitSetComponent extends Component {
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
            OperationalLimitSetService.getOperationalLimitSetById(this.state.id).then( (res) =>{
                let operationalLimitSet = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateOperationalLimitSet = (e) => {
        e.preventDefault();
        let operationalLimitSet = {
                operationalLimitSetId: this.state.id,
            };
        console.log('operationalLimitSet => ' + JSON.stringify(operationalLimitSet));

        // step 5
        if(this.state.id === '_add'){
            operationalLimitSet.operationalLimitSetId=''
            OperationalLimitSetService.createOperationalLimitSet(operationalLimitSet).then(res =>{
                this.props.history.push('/operationalLimitSets');
            });
        }else{
            OperationalLimitSetService.updateOperationalLimitSet(operationalLimitSet).then( res => {
                this.props.history.push('/operationalLimitSets');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/operationalLimitSets');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OperationalLimitSet</h3>
        }else{
            return <h3 className="text-center">Update OperationalLimitSet</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOperationalLimitSet}>Save</button>
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

export default CreateOperationalLimitSetComponent
