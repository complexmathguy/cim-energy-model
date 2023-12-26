import React, { Component } from 'react'
import ValueToAliasService from '../services/ValueToAliasService';

class CreateValueToAliasComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                value: ''
        }
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ValueToAliasService.getValueToAliasById(this.state.id).then( (res) =>{
                let valueToAlias = res.data;
                this.setState({
                    value: valueToAlias.value
                });
            });
        }        
    }
    saveOrUpdateValueToAlias = (e) => {
        e.preventDefault();
        let valueToAlias = {
                valueToAliasId: this.state.id,
                value: this.state.value
            };
        console.log('valueToAlias => ' + JSON.stringify(valueToAlias));

        // step 5
        if(this.state.id === '_add'){
            valueToAlias.valueToAliasId=''
            ValueToAliasService.createValueToAlias(valueToAlias).then(res =>{
                this.props.history.push('/valueToAliass');
            });
        }else{
            ValueToAliasService.updateValueToAlias(valueToAlias).then( res => {
                this.props.history.push('/valueToAliass');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/valueToAliass');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ValueToAlias</h3>
        }else{
            return <h3 className="text-center">Update ValueToAlias</h3>
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
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateValueToAlias}>Save</button>
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

export default CreateValueToAliasComponent
