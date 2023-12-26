import React, { Component } from 'react'
import MoneyService from '../services/MoneyService';

class CreateMoneyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            MoneyService.getMoneyById(this.state.id).then( (res) =>{
                let money = res.data;
                this.setState({
                    multiplier: money.multiplier,
                    unit: money.unit,
                    value: money.value
                });
            });
        }        
    }
    saveOrUpdateMoney = (e) => {
        e.preventDefault();
        let money = {
                moneyId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('money => ' + JSON.stringify(money));

        // step 5
        if(this.state.id === '_add'){
            money.moneyId=''
            MoneyService.createMoney(money).then(res =>{
                this.props.history.push('/moneys');
            });
        }else{
            MoneyService.updateMoney(money).then( res => {
                this.props.history.push('/moneys');
            });
        }
    }
    
    changemultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeunitHandler= (event) => {
        this.setState({unit: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/moneys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Money</h3>
        }else{
            return <h3 className="text-center">Update Money</h3>
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
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMoney}>Save</button>
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

export default CreateMoneyComponent
