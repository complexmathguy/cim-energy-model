import React, { Component } from 'react'
import LoadBreakSwitchService from '../services/LoadBreakSwitchService';

class CreateLoadBreakSwitchComponent extends Component {
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
            LoadBreakSwitchService.getLoadBreakSwitchById(this.state.id).then( (res) =>{
                let loadBreakSwitch = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLoadBreakSwitch = (e) => {
        e.preventDefault();
        let loadBreakSwitch = {
                loadBreakSwitchId: this.state.id,
            };
        console.log('loadBreakSwitch => ' + JSON.stringify(loadBreakSwitch));

        // step 5
        if(this.state.id === '_add'){
            loadBreakSwitch.loadBreakSwitchId=''
            LoadBreakSwitchService.createLoadBreakSwitch(loadBreakSwitch).then(res =>{
                this.props.history.push('/loadBreakSwitchs');
            });
        }else{
            LoadBreakSwitchService.updateLoadBreakSwitch(loadBreakSwitch).then( res => {
                this.props.history.push('/loadBreakSwitchs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/loadBreakSwitchs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadBreakSwitch</h3>
        }else{
            return <h3 className="text-center">Update LoadBreakSwitch</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadBreakSwitch}>Save</button>
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

export default CreateLoadBreakSwitchComponent
