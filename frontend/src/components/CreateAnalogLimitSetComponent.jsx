import React, { Component } from 'react'
import AnalogLimitSetService from '../services/AnalogLimitSetService';

class CreateAnalogLimitSetComponent extends Component {
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
            AnalogLimitSetService.getAnalogLimitSetById(this.state.id).then( (res) =>{
                let analogLimitSet = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAnalogLimitSet = (e) => {
        e.preventDefault();
        let analogLimitSet = {
                analogLimitSetId: this.state.id,
            };
        console.log('analogLimitSet => ' + JSON.stringify(analogLimitSet));

        // step 5
        if(this.state.id === '_add'){
            analogLimitSet.analogLimitSetId=''
            AnalogLimitSetService.createAnalogLimitSet(analogLimitSet).then(res =>{
                this.props.history.push('/analogLimitSets');
            });
        }else{
            AnalogLimitSetService.updateAnalogLimitSet(analogLimitSet).then( res => {
                this.props.history.push('/analogLimitSets');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/analogLimitSets');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AnalogLimitSet</h3>
        }else{
            return <h3 className="text-center">Update AnalogLimitSet</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAnalogLimitSet}>Save</button>
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

export default CreateAnalogLimitSetComponent
