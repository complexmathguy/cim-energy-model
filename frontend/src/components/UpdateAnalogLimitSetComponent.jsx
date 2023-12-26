import React, { Component } from 'react'
import AnalogLimitSetService from '../services/AnalogLimitSetService';

class UpdateAnalogLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAnalogLimitSet = this.updateAnalogLimitSet.bind(this);

    }

    componentDidMount(){
        AnalogLimitSetService.getAnalogLimitSetById(this.state.id).then( (res) =>{
            let analogLimitSet = res.data;
            this.setState({
            });
        });
    }

    updateAnalogLimitSet = (e) => {
        e.preventDefault();
        let analogLimitSet = {
            analogLimitSetId: this.state.id,
        };
        console.log('analogLimitSet => ' + JSON.stringify(analogLimitSet));
        console.log('id => ' + JSON.stringify(this.state.id));
        AnalogLimitSetService.updateAnalogLimitSet(analogLimitSet).then( res => {
            this.props.history.push('/analogLimitSets');
        });
    }


    cancel(){
        this.props.history.push('/analogLimitSets');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AnalogLimitSet</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAnalogLimitSet}>Save</button>
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

export default UpdateAnalogLimitSetComponent
