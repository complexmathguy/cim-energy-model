import React, { Component } from 'react'
import DayTypeService from '../services/DayTypeService';

class CreateDayTypeComponent extends Component {
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
            DayTypeService.getDayTypeById(this.state.id).then( (res) =>{
                let dayType = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDayType = (e) => {
        e.preventDefault();
        let dayType = {
                dayTypeId: this.state.id,
            };
        console.log('dayType => ' + JSON.stringify(dayType));

        // step 5
        if(this.state.id === '_add'){
            dayType.dayTypeId=''
            DayTypeService.createDayType(dayType).then(res =>{
                this.props.history.push('/dayTypes');
            });
        }else{
            DayTypeService.updateDayType(dayType).then( res => {
                this.props.history.push('/dayTypes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dayTypes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DayType</h3>
        }else{
            return <h3 className="text-center">Update DayType</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDayType}>Save</button>
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

export default CreateDayTypeComponent
