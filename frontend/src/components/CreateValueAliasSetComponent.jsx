import React, { Component } from 'react'
import ValueAliasSetService from '../services/ValueAliasSetService';

class CreateValueAliasSetComponent extends Component {
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
            ValueAliasSetService.getValueAliasSetById(this.state.id).then( (res) =>{
                let valueAliasSet = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateValueAliasSet = (e) => {
        e.preventDefault();
        let valueAliasSet = {
                valueAliasSetId: this.state.id,
            };
        console.log('valueAliasSet => ' + JSON.stringify(valueAliasSet));

        // step 5
        if(this.state.id === '_add'){
            valueAliasSet.valueAliasSetId=''
            ValueAliasSetService.createValueAliasSet(valueAliasSet).then(res =>{
                this.props.history.push('/valueAliasSets');
            });
        }else{
            ValueAliasSetService.updateValueAliasSet(valueAliasSet).then( res => {
                this.props.history.push('/valueAliasSets');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/valueAliasSets');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ValueAliasSet</h3>
        }else{
            return <h3 className="text-center">Update ValueAliasSet</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateValueAliasSet}>Save</button>
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

export default CreateValueAliasSetComponent
