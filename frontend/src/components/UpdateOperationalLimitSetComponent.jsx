import React, { Component } from 'react'
import OperationalLimitSetService from '../services/OperationalLimitSetService';

class UpdateOperationalLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateOperationalLimitSet = this.updateOperationalLimitSet.bind(this);

    }

    componentDidMount(){
        OperationalLimitSetService.getOperationalLimitSetById(this.state.id).then( (res) =>{
            let operationalLimitSet = res.data;
            this.setState({
            });
        });
    }

    updateOperationalLimitSet = (e) => {
        e.preventDefault();
        let operationalLimitSet = {
            operationalLimitSetId: this.state.id,
        };
        console.log('operationalLimitSet => ' + JSON.stringify(operationalLimitSet));
        console.log('id => ' + JSON.stringify(this.state.id));
        OperationalLimitSetService.updateOperationalLimitSet(operationalLimitSet).then( res => {
            this.props.history.push('/operationalLimitSets');
        });
    }


    cancel(){
        this.props.history.push('/operationalLimitSets');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OperationalLimitSet</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOperationalLimitSet}>Save</button>
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

export default UpdateOperationalLimitSetComponent
