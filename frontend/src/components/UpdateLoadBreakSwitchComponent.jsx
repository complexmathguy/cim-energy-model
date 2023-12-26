import React, { Component } from 'react'
import LoadBreakSwitchService from '../services/LoadBreakSwitchService';

class UpdateLoadBreakSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLoadBreakSwitch = this.updateLoadBreakSwitch.bind(this);

    }

    componentDidMount(){
        LoadBreakSwitchService.getLoadBreakSwitchById(this.state.id).then( (res) =>{
            let loadBreakSwitch = res.data;
            this.setState({
            });
        });
    }

    updateLoadBreakSwitch = (e) => {
        e.preventDefault();
        let loadBreakSwitch = {
            loadBreakSwitchId: this.state.id,
        };
        console.log('loadBreakSwitch => ' + JSON.stringify(loadBreakSwitch));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadBreakSwitchService.updateLoadBreakSwitch(loadBreakSwitch).then( res => {
            this.props.history.push('/loadBreakSwitchs');
        });
    }


    cancel(){
        this.props.history.push('/loadBreakSwitchs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadBreakSwitch</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadBreakSwitch}>Save</button>
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

export default UpdateLoadBreakSwitchComponent
